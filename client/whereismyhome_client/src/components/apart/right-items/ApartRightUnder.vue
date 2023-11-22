<script setup>
// right-bar의 아래에 적용될 view(router view의 역할)
const emit = defineEmits(["evtProcessToRightView"]);

const emitToRightView = (apartList) => {
  emit("evtProcessToRightView", apartList);
};
</script>
<template>
  <Suspense>
    <RouterView @evt-process="emitToRightView" />
  </Suspense>
</template>

<style scoped></style>
