import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function listApart(dongCode, success, fail) {
  local.get(`/apart`, { params: dongCode }).then(success).catch(fail);
}

function listApart2(dongCode) {
  return local.get(`/apart`, { params: dongCode });
}

export { listApart, listApart2 };
