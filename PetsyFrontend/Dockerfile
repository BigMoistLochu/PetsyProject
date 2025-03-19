# Pobieramy oficjalny obraz Node.js
FROM node:18

# Ustawiamy katalog roboczy
WORKDIR /app

# Kopiujemy pliki package.json i package-lock.json
COPY ./PetsyFrontend/ .
# Instalujemy zależności, w tym `http-server`
RUN npm install

# Otwieramy port 5000 (zgodnie z Twoim `package.json`)
EXPOSE 5000

# Uruchamiamy serwer
CMD ["npm", "start"]