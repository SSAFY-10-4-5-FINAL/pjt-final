<script setup>
import ApartMapView from "../components/apart/ApartMapView.vue";
import ApartRightView from "@/components/apart/ApartRightView.vue";
</script>

<template>
  <div class="container-fluid">
    <div class="item"><ApartMapView /></div>
    <div class="item"><ApartRightView /></div>
  </div>
</template>

<style scoped>
.container-fluid {
  display: grid;
  padding: 0px;
  height: 100vh;
}

.item:nth-child(1) {
  /* 1번 라인에서 9칸 */
  grid-column-start: 1;
  grid-column-end: 11;
  height: 100vh;
}
.item:nth-child(2) {
  /* 1번 라인에서 3 */
  grid-column-start: 11;
  grid-column-end: 12;
  height: 100vh;
}
</style>
