import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function getUserList() {
  return local.get(`/admin/user`);
}

function getUserDetail(loginId) {
  return local.get(`/admin/user/${loginId}`);
}

function deleteUser(loginId) {
  return local.delete(`/admin/user/${loginId}`);
}

export { getUserList, getUserDetail, deleteUser };
