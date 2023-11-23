import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function searchListDong(subdong) {
  return local.get(`/apart/searchdong/${subdong}`);
}

function listApart() {
  return local.get(`/apart/aptlistbyhit`);
}

function searchByDongCode(dongCode) {
  return local.get(`/apart`, { params: { dongCode } });
}

function getApartByAptCode(aptCode) {
  return local.get(`/apart/${aptCode}`);
}

function getStarredArea(userId) {
  return local.post(`/apart/starred/area`, userId);
}

export { searchListDong, listApart, searchByDongCode, getApartByAptCode, getStarredArea };
