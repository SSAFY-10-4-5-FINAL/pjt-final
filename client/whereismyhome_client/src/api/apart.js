import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function listApart() {
  return local.get(`/apart/aptlistbyhit`);
}

export { listApart };
