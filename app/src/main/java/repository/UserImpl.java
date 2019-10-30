/*
package repository;

public class UserImpl implements IUserRepository {

    private static final String TAG = UserImpl.class.getSimpleName();

    private Context context;

    private FirebaseFirestore db;

    private CustomApplication app;


    public UserImpl(Context context) {
        this.context = context;
        app = CustomApplication.getInstance();
        db = app.getDbInstance();
    }

    @Override
    public void doesUserEmailExist(String email, FirestoreUserModel firestoreUserModel) {
        Query query = db.collection(Constants.USER_COLLECTION).whereEqualTo("email", email);
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(Objects.requireNonNull(task.getResult()).size() > 0){
                    Toast.makeText(context, "User email already exist in the database ", Toast.LENGTH_SHORT).show();
                }else{
                    //add a new user to Firestore database
                    addNewRegisteredUser(firestoreUserModel);
                }
            }
        });
    }

    @Override
    public void addNewRegisteredUser(FirestoreUserModel firestoreUserModel) {
        String userEnteredName = firestoreUserModel.getUsername();

        Map<String, Object> user = new HashMap<>();
        user.put(Constants.DocumentFields.USERNAME, firestoreUserModel.getUsername());
        user.put(Constants.DocumentFields.EMAIL, firestoreUserModel.getEmail());
        user.put(Constants.DocumentFields.PASSWORD, firestoreUserModel.getPassword());

        Task<Void> newUser = db.collection(Constants.USER_COLLECTION).document(firestoreUserModel.getEmail()).set(user);
        newUser.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "User was successfully added");
                NavUtil.moveToNextPage(context, ProfileActivity.class, userEnteredName);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Error has occurred " + e.getMessage());
            }
        });
    }

    @Override
    public void getLoginUserByEmail(String email) {
        DocumentReference docRef = db.collection(Constants.USER_COLLECTION).document(email);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    FirestoreUserModel user = Objects.requireNonNull(task.getResult()).toObject(FirestoreUserModel.class);
                    //Navigate to profile page
                    if(user != null){
                        NavUtil.moveToNextPage(context, ProfileActivity.class, user.getUsername());
                    }else{
                        Toast.makeText(context, "Missing user record ", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    String excep = Objects.requireNonNull(task.getException()).getMessage();
                    Log.d(TAG, "Error reading user data " + excep);

                }
            }
        });
    }
}*/
