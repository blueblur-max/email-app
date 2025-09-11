AI Email Generator

This is my project where I built an AI powered email assistant that can generate professional email replies. The idea is to save time while writing emails by letting AI suggest complete replies. I worked on both the frontend and backend and also created a Chrome extension so that the assistant can be used directly inside Gmail.

Features

*Generate email replies instantly based on the received mail content
*Option to change the tone (professional, casual, friendly)
*Summarize long emails to get the key points quickly
*Categorize emails into different contexts
*Chrome extension for Gmail integration

Full stack: React frontend + Spring Boot backend

*Tech Stack

Frontend: React (Vite), TailwindCSS, Axios
Backend: Spring Boot, Spring AI (Gemini), REST APIs
Extension: Chrome Extension (Manifest v3), works directly inside Gmail

Project Structure

AI-Email-Generator/
│── email-writer-react/ → React frontend
│── email-writer-sb-gemini/ → Spring Boot backend with AI logic
│── email-writer-ext/ → Chrome extension source
│── email-writer-ext.zip → Extension packaged version
│── README.md

Setup Instructions

Backend (Spring Boot)

1.Navigate to the backend folder: cd email-writer-sb-gemini
2.Run the application: mvn spring-boot:run
3.Add your API key in application.properties as: spring.ai.openai.api-key=YOUR_API_KEY
4.The backend will start on http://localhost:8080

Frontend (React)

1.Navigate to the frontend folder: cd email-writer-react
2.Install dependencies: npm install
3.Start the dev server: npm run dev
4.The app runs on http://localhost:5173

Chrome Extension

1.Unzip email-writer-ext.zip
2.Open Chrome → Extensions → Manage Extensions → Load unpacked
3.Select the folder of the extension
4.Open Gmail and the AI reply assistant will be visible

How it Works

> The user selects or types an email in Gmail or in the frontend application
> The request is sent to the backend (Spring Boot)
> The backend calls Gemini using Spring AI and generates a reply
> The reply is returned and shown to the user
> The user can edit and send it

Future Plans

> Add support for multiple AI models (Gemini, OpenAI etc.)
> Improve email categorization with custom ML models
> Add authentication for individual users
> Host the application on cloud services
