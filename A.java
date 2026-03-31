<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Guess The Number</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h1>🎮 Guess The Number</h1>
    <p>Guess a number between <b>1 - 100</b></p>

    <input type="number" id="guessInput" placeholder="Enter your guess">
    <button onclick="checkGuess()">Check</button>

    <p id="message"></p>
    <p id="attempts">Attempts: 0</p>

    <button class="reset" onclick="resetGame()">🔄 Reset</button>
</div>

<script src="script.js"></script>
</body>
</html>


  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(135deg, #667eea, #764ba2);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    background: white;
    padding: 30px;
    border-radius: 15px;
    text-align: center;
    width: 300px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.3);
    animation: fadeIn 1s ease-in-out;
}

h1 {
    margin-bottom: 10px;
}

input {
    width: 80%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 10px;
    border: 2px solid #ccc;
    outline: none;
    transition: 0.3s;
}

input:focus {
    border-color: #667eea;
    box-shadow: 0 0 10px #667eea;
}

button {
    padding: 10px 20px;
    border: none;
    border-radius: 10px;
    background: #667eea;
    color: white;
    cursor: pointer;
    margin: 5px;
    transition: 0.3s;
}

button:hover {
    background: #5a67d8;
    transform: scale(1.05);
}

.reset {
    background: #e53e3e;
}

.reset:hover {
    background: #c53030;
}

#message {
    font-weight: bold;
    margin-top: 10px;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(-20px);}
    to { opacity: 1; transform: translateY(0);}
  }


let randomNumber = Math.floor(Math.random() * 100) + 1;
let attempts = 0;

function checkGuess() {
    let userGuess = document.getElementById("guessInput").value;
    let message = document.getElementById("message");

    if (userGuess === "") {
        message.innerText = "⚠️ Please enter a number!";
        return;
    }

    attempts++;
    document.getElementById("attempts").innerText = "Attempts: " + attempts;

    userGuess = Number(userGuess);

    if (userGuess === randomNumber) {
        message.innerText = "🎉 Correct! You guessed it!";
        message.style.color = "green";
    } else if (userGuess > randomNumber) {
        message.innerText = "📉 Too High!";
        message.style.color = "red";
    } else {
        message.innerText = "📈 Too Low!";
        message.style.color = "orange";
    }
}

function resetGame() {
    randomNumber = Math.floor(Math.random() * 100) + 1;
    attempts = 0;

    document.getElementById("attempts").innerText = "Attempts: 0";
    document.getElementById("message").innerText = "";
    document.getElementById("guessInput").value = "";
}

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Typing Game</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class="container">
    <h1>Typing Speed Game</h1>

    <p id="sentence"></p>

    <textarea id="input" placeholder="Start typing here..."></textarea>

    <p id="result"></p>

    <div class="info">
        <span id="time">Time: 0s</span>
        <span id="wpm">WPM: 0</span>
    </div>
</div>

<script src="script.js"></script>
</body>
</html>

body {
    margin: 0;
    font-family: Arial;
    background: linear-gradient(135deg, #00c6ff, #0072ff);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background: white;
    padding: 25px;
    border-radius: 15px;
    width: 400px;
    text-align: center;
    box-shadow: 0 10px 25px rgba(0,0,0,0.3);
}

#sentence {
    font-size: 18px;
    margin-bottom: 15px;
}

textarea {
    width: 100%;
    height: 100px;
    border-radius: 10px;
    padding: 10px;
    border: 2px solid #ccc;
    outline: none;
    transition: 0.3s;
}

textarea:focus {
    border-color: #0072ff;
    box-shadow: 0 0 10px #0072ff;
}

.correct {
    color: green;
}

.wrong {
    color: red;
}

.info {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
}


const sentences = [
    "JavaScript is a powerful programming language",
    "Practice typing to improve your speed",
    "Coding is fun when you build projects",
    "Always write clean and readable code",
    "Consistency is the key to success"
];

let index = 0;
let startTime;
let timerInterval;

const sentenceEl = document.getElementById("sentence");
const inputEl = document.getElementById("input");
const resultEl = document.getElementById("result");
const timeEl = document.getElementById("time");
const wpmEl = document.getElementById("wpm");

function loadSentence() {
    sentenceEl.innerText = sentences[index];
    inputEl.value = "";
    resultEl.innerText = "";
}

loadSentence();

inputEl.addEventListener("focus", () => {
    startTime = new Date();
    timerInterval = setInterval(updateTime, 1000);
});

inputEl.addEventListener("input", () => {
    let typed = inputEl.value;
    let original = sentences[index];

    if (typed === original) {
        clearInterval(timerInterval);

        let timeTaken = (new Date() - startTime) / 1000;
        let words = original.split(" ").length;
        let wpm = Math.round((words / timeTaken) * 60);

        resultEl.innerText = "✅ Correct!";
        wpmEl.innerText = "WPM: " + wpm;

        index++;
        if (index < sentences.length) {
            setTimeout(loadSentence, 1000);
        } else {
            resultEl.innerText = "🎉 Completed all sentences!";
        }
    } else {
        resultEl.innerText = "❌ Keep typing...";
    }
});

function updateTime() {
    let currentTime = Math.floor((new Date() - startTime) / 1000);
    timeEl.innerText = "Time: " + currentTime + "s";
}



const levels = {
    easy: [
        "I love coding",
        "JavaScript is fun",
        "Practice daily",
        "Code and learn",
        "Typing is easy",
        "Learn step by step",
        "Keep it simple",
        "Focus and type",
        "Small steps matter",
        "Never give up"
    ],

    medium: [
        "JavaScript is a powerful programming language",
        "Practice typing to improve your speed",
        "Coding is fun when you build projects",
        "Always write clean and readable code",
        "Consistency is the key to success",
        "Debugging helps you understand logic better",
        "Practice makes a developer perfect",
        "Learn concepts before jumping to coding",
        "Typing speed improves with practice",
        "Build projects to gain confidence"
    ],

    hard: [
        "Consistency and discipline lead to long term success in programming",
        "Typing speed improves significantly with focused and daily practice",
        "Advanced developers write clean efficient and optimized code always",
        "Understanding core concepts deeply is more important than memorizing syntax",
        "Building real world projects helps in mastering programming skills effectively",
        "Debugging complex problems improves your logical thinking ability",
        "Efficient code not only runs faster but is also easier to maintain",
        "Learning never stops in the field of software development",
        "Strong fundamentals make advanced topics easier to understand",
        "Developers must continuously adapt to new technologies and trends"
    ]
};

