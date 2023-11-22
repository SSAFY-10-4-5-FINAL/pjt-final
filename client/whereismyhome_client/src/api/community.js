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

function detailArticle(articleNo) {
  return local.get(`/board/${articleNo}`);
}

function modifyArticle(articleNo, article) {
  return local.put(`/board/${articleNo}`, JSON.stringify(article));
}

function deleteArticle(articleNo) {
  return local.put(`/board/${articleNo}`);
}

export { writeBoard, listBoard, detailArticle, modifyArticle, deleteArticle };
