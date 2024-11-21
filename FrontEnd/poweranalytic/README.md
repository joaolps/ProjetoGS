This is a [Next.js](https://nextjs.org/) project bootstrapped with [`create-next-app`](https://github.com/vercel/next.js/tree/canary/packages/create-next-app).

## Getting Started

# Instalar dependências de produção
--------------RODE ESSE COMANDO NO SEU TERMINAL--------------
npm install @azure/app-configuration@^1.8.0 @azure/identity@^4.5.0 @azure/keyvault-secrets@^4.9.0 @react-google-maps/api@^2.20.3 bcrypt@^5.1.1 chart.js@^4.4.6 next@13.5.7 oci-common@^2.99.0 oracledb@^5.2.0 react@^18 react-chartjs-2@^5.2.0 react-dom@^18

# Instalar dependências de desenvolvimento
--------------RODE ESSE COMANDO NO SEU TERMINAL--------------
npm install --save-dev @types/bcrypt@^5.0.2 @types/node@^20 @types/oracledb@^6.5.2 @types/react@^18 @types/react-dom@^18 autoprefixer@^10 eslint@^8 eslint-config-next@13.5.7 postcss@^8 tailwindcss@^3 typescript@^5


# Etapas para Integração com Banco de Dados Oracle SQL Developer

1. Instalar o Oracle Instant Client
Download:
Acesse o site oficial da Oracle (Instant Client Downloads).
Escolha a versão correspondente ao seu sistema operacional (Windows, macOS, ou Linux).
Instalação:
Extraia os arquivos em uma pasta de fácil acesso (ex.: C:\oracle\instantclient).
Configure a variável de ambiente PATH para incluir o diretório do Instant Client.
2. Instalar o SQL Developer (Opcional para Gerenciamento)
Download:
Acesse o site da Oracle (SQL Developer Downloads).
Instalação:
Baixe o arquivo e extraia-o.
Inicie o SQL Developer e configure a conexão com o banco de dados. (DISPONÍVEL EM .env.local)

First, run the development server:

```bash
npm run dev
# or
yarn dev
# or
pnpm dev
# or
bun dev
```

Open [http://localhost:3000](http://localhost:3000) with your browser to see the result.

You can start editing the page by modifying `app/page.tsx`. The page auto-updates as you edit the file.

This project uses [`next/font`](https://nextjs.org/docs/basic-features/font-optimization) to automatically optimize and load Inter, a custom Google Font.

## Learn More

To learn more about Next.js, take a look at the following resources:

- [Next.js Documentation](https://nextjs.org/docs) - learn about Next.js features and API.
- [Learn Next.js](https://nextjs.org/learn) - an interactive Next.js tutorial.

You can check out [the Next.js GitHub repository](https://github.com/vercel/next.js/) - your feedback and contributions are welcome!

## Deploy on Vercel

The easiest way to deploy your Next.js app is to use the [Vercel Platform](https://vercel.com/new?utm_medium=default-template&filter=next.js&utm_source=create-next-app&utm_campaign=create-next-app-readme) from the creators of Next.js.

Check out our [Next.js deployment documentation](https://nextjs.org/docs/deployment) for more details.
