import {IStudent} from "../models/IStudent";

export class StudentDAO {
  static studentDao: IStudent[] = [
    {
      id: 1,
      name: "Hồng Nhung",
      age: 22,
      gender: "Female",
      phone : +84931934803,
      mark: 8,
      avatar: ""
    },
    {
      id: 2,
      name: "Jery",
      age: 4,
      gender : "Male",
      phone : +84931934803,
      mark: 5,
      avatar: ""
    },
    {
      id: 3,
      name: "Hoa",
      age: 63,
      gender : "Male",
      phone : +84931934803,
      mark: 9,
      avatar: ""
    }
  ]
}
