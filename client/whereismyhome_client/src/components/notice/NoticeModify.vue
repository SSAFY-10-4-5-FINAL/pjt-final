<script setup>
import NoticeFormItem from "./item/NoticeFormItem.vue";
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 text-center">공지사항</h2>
      </div>
      <div class="col-lg-10 text-start">
        <Suspense>
          <NoticeFormItem mode="modify" />
        </Suspense>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
