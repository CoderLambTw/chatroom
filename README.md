# Chatroom application

A simple application work with websocket, springboot and SockJS.

## Table of contents

* [General info](#general-info)
* [Technologies Used](#technologies-used)
* [How To Start](#how-to-start)

## General info

利用websocket實現基本聊天室功能

## Technologies Used

Project is created with：

* Spring Boot version: 3.0.1
* ngrok
* SockJS
* SockJS.min.js
* Stomp.min.js

## How To Start

### 前置作業

1. Clone該專案：
    * ```git clone https://github.com/CoderLambTw/chatroom.git```
2. 安裝ngrok至本機
    * macOS User: 直接至終端機輸入 ```brew install --cask ngrok```即可完成安裝
    * windows User: 可至 [ngrok](https://ngrok.com/) 下載

### 啓動專案

1. Start ngrok(windows使用者需先自行啓動ngrok.exe):
    * 至終端機(command)輸入```ngrok http 9527```
    * 利用 ngrok 將本機Server (localhost) 發布到一個真實ip
    * 使User傳送的訊息可以透過此ip, 再透過Line bot傳送到我們的Server
    * 成功啓動後將 *Forwarding* 的 URL 複製 https://XXXXXXXX.ngrok.io 部分替換```script.js```檔案中第五行baseURL的值

2. Start spring boot application
3. 本地使用者可直接於 http://localhost:9527 使用聊天室功能，如爲外部使用者可連線至第一點所產生的ngrok URL即可

