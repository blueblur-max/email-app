# AI Email Generator

This is my project where I built an AI powered email assistant that can generate professional email replies. The idea is to save time while writing emails by letting AI suggest complete replies. I worked on both the frontend and backend and also created a Chrome extension so that the assistant can be used directly inside Gmail.

---

## Features
- Generate email replies instantly based on the received mail content  
- Option to change the tone (professional, casual, friendly)  
- Summarize long emails to get the key points quickly  
- Categorize emails into different contexts  
- Chrome extension for Gmail integration  
- Full stack: React frontend + Spring Boot backend  

---

## Tech Stack
**Frontend**
- React (Vite)
- TailwindCSS
- Axios

**Backend**
- Spring Boot
- Spring AI (Gemini)
- REST APIs

**Extension**
- Chrome Extension (Manifest v3)
- Works directly inside Gmail

---

## Project Structure
AI-Email-Generator/
│── email-writer-react/ -> React frontend
│── email-writer-sb-gemini/ -> Spring Boot backend with AI logic
│── email-writer-ext/ -> Chrome extension source
│── email-writer-ext.zip -> Extension packaged version
│── README.md

yaml
Copy code

---

## Setup Instructions

### Backend (Spring Boot)
1. Go to the backend folder:
   ```bash
   cd email-writer-sb-gemini
   mvn spring-boot:run
Add your API key in application.properties:

properties
Copy code
spring.ai.openai.api-key=YOUR_API_KEY
The backend will start on http://localhost:8080

Frontend (React)
Go to the frontend folder:

bash
Copy code
cd email-writer-react
npm install
npm run dev
The app runs on http://localhost:5173

Chrome Extension
Unzip email-writer-ext.zip

Open Chrome → Extensions → Manage Extensions → Load unpacked

Select the folder of the extension

Open Gmail and the AI reply assistant will be visible

How it Works
The user selects or types an email in Gmail or frontend

The request goes to backend (Spring Boot)

Backend calls Gemini using Spring AI and generates a reply

Reply is sent back and shown to user

User can edit and send it

Future Plans
Add support for multiple AI models (Gemini, OpenAI etc)

Improve email categorization with custom ML models

Add authentication for individual users

Host it on cloud services
