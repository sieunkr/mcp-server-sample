<template>
    <div class="chat-container">
        <div class="chat-messages">
            <div v-for="(msg, index) in messages" :key="index" :class="msg.role">
                <div v-if="msg.role === 'user'">
                    <span>{{ msg.content }}</span>
                </div>
                <div v-else v-html="renderPlainText(msg.content)"></div>
            </div>

            <!-- 로딩 중 표시 -->
            <div v-if="loading" class="assistant loading">
                답변 작성 중...
            </div>
        </div>

        <form @submit.prevent="sendMessage" class="chat-input">
            <input v-model="userInput" placeholder="메시지를 입력하세요" />
            <button type="submit">전송</button>
        </form>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import axios from 'axios'

const messages = ref([])
const userInput = ref('')
const loading = ref(false)

const renderPlainText = (text) => {
    return text.replace(/\n/g, '<br>')
}

const sendMessage = async () => {
    const content = userInput.value.trim()
    if (!content) return

    messages.value.push({ role: 'user', content })
    userInput.value = ''
    loading.value = true

    try {
        const response = await axios.get('http://localhost:8080/agent/test', {
            params: { prompt: content }
        })

        messages.value.push({
            role: 'assistant',
            content: response.data
        })
    } catch (error) {
        messages.value.push({
            role: 'assistant',
            content: '❗ 오류가 발생했습니다.'
        })
    } finally {
        loading.value = false
    }
}
</script>

<style scoped>
.chat-container {
    width: 800px;
    margin: auto;
    padding: 16px;
    display: flex;
    flex-direction: column;
    height: 90vh;
    border: 1px solid #ddd;
    border-radius: 10px;
    font-family: system-ui, sans-serif;
    background-color: #ffffff;
}

.chat-messages {
    flex: 1;
    overflow-y: auto;
    padding: 10px;
    border-bottom: 1px solid #eee;
    font-size: 15px;
    line-height: 1.4;
}

.user {
    text-align: right;
    margin-bottom: 6px;
    font-weight: 500;
}

.assistant {
    text-align: left;
    background: #f6f6f6;
    padding: 6px 10px;
    border-radius: 6px;
    margin-bottom: 6px;
    white-space: pre-wrap;
    line-height: 1.3;
}

.loading {
    font-style: italic;
    color: #888;
    animation: blink 1s infinite;
}

@keyframes blink {
    0%, 100% { opacity: 1; }
    50% { opacity: 0.4; }
}

.chat-input {
    display: flex;
    margin-top: 8px;
}

.chat-input input {
    flex: 1;
    padding: 8px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
}

.chat-input button {
    margin-left: 8px;
    padding: 8px 12px;
    font-size: 14px;
    cursor: pointer;
    background-color: #1976d2;
    color: white;
    border: none;
    border-radius: 4px;
}
</style>