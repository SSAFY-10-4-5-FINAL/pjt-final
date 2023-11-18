export default [
  {
    path: "/recommend",
    name: "ApartRecommend",
    component: () =>
      import("@/components/apart/right-items/ApartRecommend.vue"),
  },
  {
    path: "/list",
    name: "ApartList",
    component: () => import("@/components/apart/right-items/ApartList.vue"),
  },
  {
    path: "/.apartNo",
    name: "ApartDetail",
    component: () => import("@/components/apart/right-items/ApartDetail.vue"),
  },
];
