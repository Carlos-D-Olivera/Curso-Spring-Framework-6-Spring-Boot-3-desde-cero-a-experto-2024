// SOLID

// Single responsability principle - SRP

class User {
  private name: string = "";
  private lastName: string = "";

  constructor(name: string, lastName: string) {
    this.name = name;
    this.lastName = lastName;
  }

  public whoAmI() {
    console.log(`Hello I'm ${this.name} ${this.lastName}`);
  }

  // No cumplir el principio de SRP
  // public sendMail() {}
}

// Open/Close principle
class UserWithMail extends User {
  private email: string = "";
  constructor(name: string, lastName: string, email: string) {
    super(name, lastName);
    this.email = email;
  }

  public tellMe() {
    console.log("I'm telling you");
  }
}

const users: User[] = [new User("", ""), new UserWithMail("", "", "")];

users.forEach((user) => {
  if (user instanceof User) {
    user.whoAmI();
  }

  if (user instanceof UserWithMail) {
    user.tellMe();
  }

  const u = {
    name: "Cesar",
    lastName: "Bermudez",
  };
  const key: any = "name";
  if (key === "name") {
  } else if (key === "lastName") {
  } else {
  }
  switch (key) {
    case "name":
      console.log("who ho!");
      break;

    case "lastName":
      console.log("yiha!");
      break;
    default:
      console.log("Indetificate");
      break;
  }
});

// Liskov sustitution principle
abstract class Bird {
  public eat() {}
  public giveBirth() {}
  public popis() {}
  public makeSound() {}
}

class BirdWhichCanFly extends Bird {
  public fly() {}
}

class BirdWhichCannonFly extends Bird {
  public run() {}
}

class Penguin extends Bird {
  public slide() {}

  public swimm() {}
}

// Interface Segregation Principle
// interface Hero {
//   volar: () => {};
//   superFuerza: () => {};
//   correrRapido: () => {};
// }

interface Volar {
  volar: () => {};
}

interface SuperFuerza {
  superFuerza: () => {};
}

interface CorrerRapido {
  correrRapido: () => {};
}

interface LanzarRayo {
  lanzarRayo: () => {};
}

class IronMan implements Volar, LanzarRayo {
  volar: () => {};

  lanzarRayo: () => {};
}

// Dependecy Inversion Principle

interface IDatabase {
  getById: (id: number) => {};
}

class DatabaseMysql implements IDatabase {
  getById: (id: number) => {};
}

class DatabaseMongo implements IDatabase {
  getById: (id: number) => {};
}

class UserService {
  constructor(private readonly database: IDatabase) {}
  getUser(id: number) {
    this.database.getById(id);
    // Motor de base de datos
    // PreparedStatement
    // ResultSet
  }
}

class BussinesService {
  constructor(private readonly database: IDatabase) {}

  getBussiness(id: number) {
    this.database.getById(id);
  }
}

class DatabaseFactory {
  getAdapter(type: string): IDatabase {
    let db: IDatabase;
    switch (type) {
      case "mysql":
        db = new DatabaseMysql();
        break;

      case "mongo":
        db = new DatabaseMongo();
      default:
        throw new Error("Database not supported");
    }
    return db;
  }
}

// const mysql = new DatabaseMysql();
// const mongo = new DatabaseMongo();

const db = new DatabaseFactory().getAdapter("redis");

// Patrones de diseno // Factory
const userService = new UserService(db);
const bussinesService = new BussinesService(db);
