import { localAxios } from "@/utils/http-commons";

const local = localAxios();

function writeNoticeBoard(article) {
  console.log("at api");
  console.log(JSON.stringify(article));
  return local.post(`/noticeboard`, JSON.stringify(article));
}

function listNoticeBoard() {
  return local.get(`/noticeboard`);
}

function detailNoticeArticle(articleNo) {
  return local.get(`/noticeboard/${articleNo}`);
}

function modifyNoticeArticle(articleNo, article) {
  return local.put(`/noticeboard/${articleNo}`, JSON.stringify(article));
}

function deleteNoticeArticle(articleNo) {
  return local.delete(`/noticeboard/${articleNo}`);
}

export {
  writeNoticeBoard,
  listNoticeBoard,
  detailNoticeArticle,
  modifyNoticeArticle,
  deleteNoticeArticle,
};
