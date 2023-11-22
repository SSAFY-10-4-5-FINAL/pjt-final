import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function writeBoard(article) {
  console.log("at api");
  console.log(JSON.stringify(article));
  return local.post(`/board`, JSON.stringify(article));
}

function listBoard() {
  return local.get(`/board`);
}

function detailArticle(articleno) {
  return local.get(`/board/${articleno}`);
}

export { writeBoard, listBoard, detailArticle };
