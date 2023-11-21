<script setup>
import RentalFormItem from "./item/RentalFormItem.vue";
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 text-center">매물 수정</h2>
      </div>
      <div class="col-lg-10 text-start">
        <RentalFormItem type="modify" />
      </div>
    </div>
  </div>
</template>

<style scoped></style>
