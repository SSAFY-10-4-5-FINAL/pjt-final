<script setup>
import { ref } from "vue";

// Data
const props = defineProps({ index: Number, apart: Object });
</script>
<template>
  <div id="apart-brief-wrap">
    <h4>{{ apart.apartmentName }}</h4>
    <p>{{ apart.sidoName + " " + apart.gugunName }}</p>
    <p>{{ apart.roadName }}</p>
  </div>
</template>
<style scoped>
#apart-brief-wrap {
  height: 125px;
  width: 100%;
  border: 1px solid #708090;
  margin: 0.5px;
  padding: 4px;
}
p {
  margin-top: 20px;
}
</style>
