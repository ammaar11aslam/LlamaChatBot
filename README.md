# LlamaChatBot 🤖📱

A simple Android chatbot app built for SIT305 Task 8.1C, using a Flask-based Llama 2 backend.

## ✨ Features

- 🔐 User login with name input  
- 💬 Real-time chat interface  
- 🤖 Connects to Llama 2 chatbot via Flask backend  
- 💙 Custom chat UI with message bubbles and scrolling  
- ⚡ Clean and responsive layout  

## 📱 Screenshots

![Login and Chat UI](design/screenshot.png)

## 🔧 Project Structure

```
app/
├── java/com/demo/llamachat/
│   ├── MainActivity.kt
│   ├── ChatActivity.kt
│   └── ApiService.kt
├── res/layout/
│   ├── activity_main.xml
│   └── activity_chat.xml
├── res/drawable/
│   ├── user_message_bg.xml
│   └── bot_message_bg.xml
├── AndroidManifest.xml
```

## 🚀 How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/ammaar11aslam/LlamaChatBot.git
   ```

2. Clone the backend repo and start the Flask server:
   ```bash
   git clone https://github.com/sit3057082025/BackendTask8.1C.git
   cd BackendTask8.1C
   python main-ollama.py
   ```

3. Build and run the app in Android Studio.

## 📡 Backend

The backend Flask server for Llama 2 is located at:  
🔗 [https://github.com/sit3057082025/BackendTask8.1C](https://github.com/sit3057082025/BackendTask8.1C)
