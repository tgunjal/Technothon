import { faker } from '@faker-js/faker';
import { sample } from 'lodash';

const users = [...Array(24)].map((_, index) => ({
  id: faker.datatype.uuid(),
  name: faker.name.fullName(),
  age: faker.datatype.number(),
  gender: sample(['Male', 'Female']),
  survivalStatus: faker.datatype.boolean(),
}));

export default users;
