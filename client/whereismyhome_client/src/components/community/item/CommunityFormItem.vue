<script setup>
const props = defineProps({ type: String });
</script>

<template>
  <form @submit.prevent="onSubmit">
    <div class="mb-3">
      <label for="userid" class="form-label">작성자 ID : </label>
      <input type="text" class="form-control" placeholder="작성자ID..." />
    </div>
    <div class="mb-3">
      <label for="subject" class="form-label">제목 : </label>
      <input type="text" class="form-control" placeholder="제목..." />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea class="form-control" rows="10"></textarea>
    </div>
    <div class="col-auto text-center">
      <button type="submit" class="btn mb-3" style="color: black">확인</button>
      <button type="button" class="btn mb-3 ms-1">
        <RouterLink :to="{ name: 'CommunityList' }" style="text-decoration: none; color: black"
          >목록으로이동...</RouterLink
        >
      </button>
    </div>
  </form>
</template>

<style scoped></style>
