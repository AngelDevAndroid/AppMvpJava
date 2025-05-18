package com.angandroid.appmvprxjava.network;

import com.angandroid.appmvprxjava.realm.DevelopersModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmRepository {

    Realm realm;
    @Inject
    public RealmRepository(Realm realm) {
        this.realm = realm;
    }

    public int setIdRealm() {
        Number currentIdNum = realm.where(DevelopersModel.class).max("id");
        int nextId;
        if (currentIdNum == null) {
            nextId = 0;
        }else {
            nextId = currentIdNum.intValue() + 1;
        }
        return nextId;
    }

    public Completable rSaveDevel(DevelopersModel model) {
        return Completable.create(emitter -> {
            realm.executeTransactionAsync(
                    bgRealm -> {
                        bgRealm.insertOrUpdate(model);
                    },
                    () -> {
                        // Success
                        realm.close();
                        if (!emitter.isDisposed()) {
                            emitter.onComplete();
                        }
                    },
                    error -> {
                        // Error
                        realm.close();
                        if (!emitter.isDisposed()) {
                            emitter.onError(error);
                        }
                    }
            );
        });
    }

    public Single<List<DevelopersModel>> getDevelopers() {
        return Single.create(emitter -> {
            try {
                RealmResults<DevelopersModel> results = realm.where(DevelopersModel.class).findAll();
                List<DevelopersModel> users = realm.copyFromRealm(results); // detach de Realm
                emitter.onSuccess(users);
            } catch (Exception e) {
                emitter.onError(e);
            } finally {
                realm.close();
            }
        });
    }

    public Completable deleteDeveloper(int userId) {
        return Completable.create(emitter -> {
            realm.executeTransactionAsync(
                    transactionRealm -> {
                        DevelopersModel devs = transactionRealm
                                .where(DevelopersModel.class)
                                .equalTo("id", userId).findFirst();
                        if (devs != null) {
                            devs.deleteFromRealm();
                        }
                    },
                    () -> {
                        emitter.onComplete(); // Success
                        realm.close();
                    },
                    error -> {
                        emitter.onError(error); // Error
                        realm.close();
                    }
            );
        });
    }
}
