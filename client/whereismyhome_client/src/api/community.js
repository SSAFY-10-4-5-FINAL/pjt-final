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

function listBoardBySearch(searchInput) {
  return local.get(`/board`, { params: { title: searchInput } });
}

function detailArticle(articleNo) {
  return local.get(`/board/${articleNo}`);
}

function modifyArticle(articleNo, article) {
  return local.put(`/board/${articleNo}`, JSON.stringify(article));
}

function deleteArticle(articleNo) {
  return local.delete(`/board/${articleNo}`);
}

export {
  writeBoard,
  listBoard,
  listBoardBySearch,
  detailArticle,
  modifyArticle,
  deleteArticle,
};
