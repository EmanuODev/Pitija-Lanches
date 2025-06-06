/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {

    extend: {

      fontFamily: {
        Montserrat: ["Montserrat","serif"],
        Kanit: ["Kanit", "serif"],
        Outfit: ["Outfit", "serif"],
        Exile: ["Exile", "Static"],
        Fascinate: ["Fascinate", "Static"],
        Flamenco: ["Flamenco", "Static"],
        Josefin: ["Josefin", "Sans"],
        Marker: ["Permanent Marker", "Static"]
      },

      boxShadow: {
        submit: '0px 0px 4px 2px rgba(0, 0, 0, 0.2)',
      }

    },

  },

  plugins: [
    require("@designbycode/tailwindcss-text-shadow"),
  ],
}
