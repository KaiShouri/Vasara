<template>
  <q-card class="col-8 q-pa-lg q-ma-md card" flat>
    <div class="row no-wrap items-center q-mt-md">
    <q-chip
      v-for="(fandom, index) in story.fandoms"
      :key="index"
      class="chip bg-accent-purple"
      >{{ fandom }}</q-chip
    >

    <q-space/>
    <q-chip v-if="!story.finished" class="bg-accent-gold chip">🔓 in progress</q-chip>
    <q-chip v-else class="bg-accent-gold chip">🔒 completed</q-chip>
    </div>
    <div>
      <q-chip
      v-for="(tag, index) in story.tags"
      :key="index"
      class="chip bg-accent-pink"
      >{{ tag }}</q-chip
    >
    </div>
    <div class="text-h3 q-mb-md">
      {{ story.title }}
    </div>
    <div class="text-h5">{{ story.authorName }}</div>
    <div class="q-mt-sm q-mb-sm">
      <strong>published: </strong> {{ formatDate(story.publishDt) }}
    </div>
    <span class="q-mt-sm q-mb-sm">
      <strong> last update: </strong>{{ formatDate(story.updateDt) }}</span
    >
    <p class="text-body1 q-mt-md">
      {{ story.description }}
    </p>
    <div class="text-h5 q-mb-md">
      Chapters {{ story.chaptersNumber }} /
      {{ !story.finished ? "?" : story.chaptersNumber }}
    </div>
    <q-separator inset />
    <q-btn
      :disabled="story.chaptersNumber == 0"
      @click="readChapter"
      class="q-my-md btn"
      flat
      >Read</q-btn
    >
    <slot></slot>
  </q-card>
</template>

<script setup>
import { format } from "date-fns";
import { useRouter } from "vue-router";
const router = useRouter();

const props = defineProps({
  story: {
    type: Object,
    required: true,
  },
});

const formatDate = (date) => {
  return format(new Date(date), "dd.MM.yyyy");
};

const readChapter = () => {
  router.push({
    path: "/read",
    query: {
      storyId: props.story.id,
      chapterNo: 1,
    },
  });
};
</script>

<style scoped>
.btn {
  font-family: "Farro", sans-serif;
  font-weight: 400;
  font-style: normal;
  color: #333 !important;
}

a:visited {
  color: #333;
}

.chip {
  border-radius: 3px !important;
}

img {
  width: 50px;
}
</style>
