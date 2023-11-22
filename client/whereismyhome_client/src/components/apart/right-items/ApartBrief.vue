<script setup>
// Data
const props = defineProps({ apart: Object });
const a = props.apart;
console.log("아파트", a.value);
</script>
<template>
  <div id="apart-brief-wrap">
    <h4>{{ a.apartmentName }}</h4>
    <p>{{ a.sidoName + " " + a.gugunName }}</p>
    <p>{{ a.roadName }}</p>
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
