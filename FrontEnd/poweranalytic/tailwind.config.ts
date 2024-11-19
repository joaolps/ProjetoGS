import { Config } from 'tailwindcss';

const config: Config = {
  content: ['./src/**/*.{js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        'neon-green': '#39ff14', // Adiciona a cor personalizada
      },
    },
  },
  plugins: [],
};

export default config;
