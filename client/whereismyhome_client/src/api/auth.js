import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function register(registerUser) {
  return local.post(`/auth/register`, JSON.stringify(registerUser));
}

function login(loginUser) {
  return local.post(`/auth/login`, JSON.stringify(loginUser));
}

export { register, login };
