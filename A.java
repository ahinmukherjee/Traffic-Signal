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

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Solar System</title>
<style>
  body {
    margin: 0;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: radial-gradient(circle, #000 60%, #020b1a);
    overflow: hidden;
  }

  .solar-system {
    position: relative;
    width: 400px;
    height: 400px;
  }

  .sun {
    position: absolute;
    width: 80px;
    height: 80px;
    background: radial-gradient(circle, yellow, orange);
    border-radius: 50%;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 0 0 40px orange;
  }

  .earth-orbit {
    position: absolute;
    width: 250px;
    height: 250px;
    border: 1px dashed rgba(255,255,255,0.2);
    border-radius: 50%;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    animation: orbitEarth 10s linear infinite;
  }

  .earth {
    position: absolute;
    width: 40px;
    height: 40px;
    background: blue;
    border-radius: 50%;
    top: -20px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .moon-orbit {
    position: absolute;
    width: 80px;
    height: 80px;
    border: 1px dashed rgba(255,255,255,0.2);
    border-radius: 50%;
    animation: orbitMoon 3s linear infinite;
  }

  .moon {
    position: absolute;
    width: 15px;
    height: 15px;
    background: gray;
    border-radius: 50%;
    top: -7px;
    left: 50%;
    transform: translateX(-50%);
  }

  @keyframes orbitEarth {
    from { transform: translate(-50%, -50%) rotate(0deg); }
    to { transform: translate(-50%, -50%) rotate(360deg); }
  }

  @keyframes orbitMoon {
    from { transform: rotate(0deg); }
    to { transform: rotate(360deg); }
  }

  .controls {
    position: absolute;
    bottom: 20px;
    display: flex;
    gap: 10px;
  }

  button {
    padding: 10px 15px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    background: #222;
    color: white;
  }

  button:hover {
    background: #444;
  }
</style>
</head>
<body>

<div class="solar-system" id="system">
  <div class="sun"></div>

  <div class="earth-orbit" id="earthOrbit">
    <div class="earth">
      <div class="moon-orbit" id="moonOrbit">
        <div class="moon"></div>
      </div>
    </div>
  </div>
</div>

<div class="controls">
  <button onclick="speedUp()">Speed Up</button>
  <button onclick="slowDown()">Slow Down</button>
  <button onclick="pauseOrbit()">Pause</button>
</div>

<script>
  let earthSpeed = 10;
  let moonSpeed = 3;

  function updateSpeed() {
    document.getElementById("earthOrbit").style.animationDuration = earthSpeed + "s";
    document.getElementById("moonOrbit").style.animationDuration = moonSpeed + "s";
  }

  function speedUp() {
    earthSpeed = Math.max(2, earthSpeed - 2);
    moonSpeed = Math.max(1, moonSpeed - 1);
    updateSpeed();
  }

  function slowDown() {
    earthSpeed += 2;
    moonSpeed += 1;
    updateSpeed();
  }

  function pauseOrbit() {
    const earth = document.getElementById("earthOrbit");
    const moon = document.getElementById("moonOrbit");

    if (earth.style.animationPlayState === "paused") {
      earth.style.animationPlayState = "running";
      moon.style.animationPlayState = "running";
    } else {
      earth.style.animationPlayState = "paused";
      moon.style.animationPlayState = "paused";
    }
  }

  updateSpeed();
</script>

</body>
</html>
