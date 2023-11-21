import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function listBoard() {
  return local.get(`/board`);
}

export { listBoard };
