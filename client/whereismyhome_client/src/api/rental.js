import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function writeRentalBoard(article) {
  console.log("at api");
  console.log(JSON.stringify(article));
  return local.post(`/rentalboard`, JSON.stringify(article));
}

function listRentalBoard() {
  return local.get(`/rentalboard`);
}

function listRentalBoardBySearch(searchInput) {
  return local.get(`/rentalboard`, { params: { title: searchInput } });
}

function detailRentalArticle(articleNo) {
  return local.get(`/rentalboard/${articleNo}`);
}

function modifyRentalArticle(articleNo, article) {
  return local.put(`/rentalboard/${articleNo}`, JSON.stringify(article));
}

function deleteRentalArticle(articleNo) {
  return local.delete(`/rentalboard/${articleNo}`);
}

export {
  writeRentalBoard,
  listRentalBoard,
  listRentalBoardBySearch,
  detailRentalArticle,
  modifyRentalArticle,
  deleteRentalArticle,
};
