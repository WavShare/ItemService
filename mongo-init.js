console.log("Switching to item database...");
db = db.getSiblingDB(process.env.MONGO_DATABASE);

console.log("Initializing MongoDB user...");

db.createUser(
    {
        user: process.env.MONGO_USERNAME,
        pwd: process.env.MONGO_PASSWORD,
        roles: [
            {
                role: "readWrite",
                db: process.env.MONGO_DATABASE
            }
        ]
    }
);

console.log("MongoDB user created successfully!");