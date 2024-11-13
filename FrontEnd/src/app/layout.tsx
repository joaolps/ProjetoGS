import '../styles/globals.css';
import { ReactNode } from 'react';

export const metadata = {
  title: 'My Nex    t.js App',
  description: 'Bem-vindo ao meu site!',
};

export default function RootLayout({ children }: { children: ReactNode }) {
  return (
    <html lang="pt-BR">
      <body>{children}</body>
    </html>
  );
}
