import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function searchListDong(subdong) {
  return local.get(`/apart/searchdong/${subdong}`);
}

function listApart() {
  return local.get(`/apart/aptlistbyhit`);
}

export { searchListDong, listApart };
