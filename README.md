
A **3D Traffic Signal simulation built using Core Java Swing and AWT**.  
This project shows a realistic traffic light system with:

- 🔴 Red light → **30 sec**
- 🟡 Yellow light → **5 sec**
- 🟢 Green light → **25 sec**

The signal automatically changes with a **live countdown timer**, gradient body design, glow effects, and smooth UI rendering.

---

## ✨ Features
- 🚦 3D style traffic signal design
- 🎨 Gradient signal body
- 💡 Glow effect for active light
- ⏱️ Live countdown timer
- 🔄 Automatic light switching
- 🖥️ Java Swing GUI
- 🪄 Anti-aliasing smooth graphics
- 🎯 Beginner-friendly animation project

---

## 🛠️ Technologies Used
- Java
- Core Java
- Swing
- AWT
- Timer
- Graphics2D
- GradientPaint
- OOP Concepts

---


## 💻 Core Timer Logic
```java
Timer timer = new Timer(1000, e -> {
    countdown--;

    if (countdown <= 0) {
        if (currentLight == 0) {
            currentLight = 1;
            countdown = 5;
        } else if (currentLight == 1) {
            currentLight = 2;
            countdown = 25;
        } else {
            currentLight = 0;
            countdown = 30;
        }
    }
    repaint();
});

```
