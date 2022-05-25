import {ICategory} from "./ICategory";

export class IProduct {
  id?: number;
  name?: string;
  price?: number;
  description?: any;
  category?: {
    id: number;
    nameCategory: string;
  };
}
