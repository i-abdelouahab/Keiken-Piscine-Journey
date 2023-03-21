/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js}"],
  theme: {
    extend: {
      gradientColorStops: {
        'primary': '#00d4ff',
      'secondary': '#090979',
      },
      fontFamily: {
        'geo': ['Georgia'], // Add a new font family
      },
      screens: {
        '3xl': '1536px', // Add a new screen size for extra large screens
      },
      },
  },
  plugins: [
    require('tailwindcss'),
  ],
}
