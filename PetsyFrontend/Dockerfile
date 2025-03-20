# Pobieramy oficjalny obraz Node.js
FROM node:18
WORKDIR /app

COPY ./PetsyFrontend/package.json .
COPY ./PetsyFrontend/src ./src

RUN npm install
EXPOSE 5000
# Uruchamiamy serwer
CMD ["npm", "start"]