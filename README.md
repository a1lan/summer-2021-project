# summer-2021-project

## Contents

  * [Installation](#installation)
  * [Development](#development)
  * [Commands](#commands)

## Installation

#### Clone the repository

```console
git clone git@github.com:a1lan/summer-2021-project.git
```

#### Install Expo CLI

```console
npm install -g expo-cli
```

#### Install Expo App

On your phone, find and install the Expo app by Expo Project.

#### Install dependencies

Run the following from the `app/src` directory:

```console
npm install
```

## Development

#### Start Expo

If you are on android:

```console
npm run android
```

If you are instead on iOS:

```console
npm run ios
```

The Expo developer tools should now open in your browser.

#### Configure Expo developer tools

If you are using WSL on Windows, change 'Connection' from 'LAN' to 'Tunnel'.

#### Scan QR Code

Using the Camera or Expo app, scan the QR code.

## Commands

`/app/src`

|Command|Description|
|-------|-----------|
| `npm run android` | Start Expo for android |
| `npm run ios` | Start Expo for iOS |