export default [
  {
    path: "write",
    name: "NoticeWrite",
    component: () => import("@/components/notice/NoticeWrite.vue"),
  },
  {
    path: "list",
    name: "NoticeList",
    component: () => import("@/components/notice/NoticeList.vue"),
  },
  {
    path: ":articleNo",
    name: "NoticeDetail",
    component: () => import("@/components/notice/NoticeDetail.vue"),
  },

  {
    path: ":articleNo",
    name: "NoticeModify",
    component: () => import("@/components/notice/NoticeModify.vue"),
  },
];
