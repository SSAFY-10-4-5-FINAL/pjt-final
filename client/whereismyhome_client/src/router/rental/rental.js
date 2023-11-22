export default [
  {
    path: "write",
    name: "RentalWrite",
    component: () => import("@/components/rental/RentalWrite.vue"),
  },
  {
    path: "list",
    name: "RentalList",
    component: () => import("@/components/rental/RentalList.vue"),
  },
  {
    path: ":articleNo",
    name: "RentalDetail",
    component: () => import("@/components/rental/RentalDetail.vue"),
  },

  {
    path: ":articleNo",
    name: "RentalModify",
    component: () => import("@/components/rental/RentalModify.vue"),
  },
];
