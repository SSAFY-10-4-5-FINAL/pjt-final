import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function listApart(dongCode) {
  return local.get(`/apart`, { params: dongCode });
}

export { listApart };

