export default [
  {
    path: "right",
    name: "ApartRightView",
    component: () => import("@/components/apart/ApartRightView.vue"),
    children: [
      {
        path: "under",
        name: "ApartRightUnder",
        component: () => import("@/components/apart/right-items/ApartRightUnder.vue"),
        redirect: "/apart/right/under/recommend",
        children: [
          {
            path: "recommend",
            name: "ApartRecommend",
            component: () => import("@/components/apart/right-items/ApartRecommend.vue"),
          },
          {
            path: "list/:dongCode",
            name: "ApartList",
            component: () => import("@/components/apart/right-items/ApartList.vue"),
          },
          {
            path: "detail/:aptCode",
            name: "ApartDetail",
            component: () => import("@/components/apart/right-items/ApartDetail.vue"),
          },
        ],
      },
    ],
  },
];
