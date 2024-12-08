import { api } from "../boot/axios";

export const fetchStories = async () => {
  try {
    const response = await api.get("/stories/all");
    return response.data;
  } catch (error) {
    console.error("Error fetching stories:", error);
    throw error;
  }
};

export const fetchMyStories = async () => {
  try {
    const id = 1;
    const response = await api.get(`/stories/my/${id}`);
    return response.data;
  } catch (error) {
    console.error("Error fetching stories:", error);
    throw error;
  }
};

export const createStory = async (storyData) => {
  try {
    console.log(storyData);
    const response = await api.post("/stories/add", storyData);
    return response.data;
  } catch (error) {
    console.error("Error creating story:", error);
    throw error;
  }
};
