import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function listBoard() {
  return local.get(`/board`);
}

function detailArticle(articleno) {
  return local.get(`/board/${articleno}`);
}

export { listBoard, detailArticle };
