using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace crip
{
    class Program
    {
        //Funçao de criação de caracteres aleatorios
        static string Aleat09(int seed, int num = 1)
        {
            StringBuilder num09 = new StringBuilder();
            string carac = "7516403982";
            Random r = new Random();
            int seed2 = r.Next(seed);
            for (int i = 0; i < num; i++)
            {
                Random rnd = new Random(seed + seed2 + DateTime.Now.Millisecond);
                int x = rnd.Next(carac.Length);
                num09.Append(carac[x]);
                seed2 += 177;
            }

            return num09.ToString();

        }

        // Começo do Programa
        static void Main(string[] args)
        {
        comeco:
            // Declaração/Atribuição de váriaveis
            StringBuilder MsgCrip = new StringBuilder();
            // A variável "letras" contém todos os caracteres possiveis na hora da digitação da mensagem
            string letras = " ABCDEFGHIJKLMNOPQRSTUVXWYZabcdefghijklmnopqrstuvxwyzÁÀÃÂÈÉÊÍÌÎÓÒÔÕÙÚÛáàâãèéêìíîóòôõúùûçÇ,.():?!";
            string escolha, mensagem, chaved;
            int chave = 5, troca = 0, chave1, mp2 = 0, mp3 = 0;
            char[] text_inv = new char[0];
            char[] descarte = new char[0];
            bool volta = false, voltac = false, chaveint;
            Console.WriteLine("Bem vindo ao maior sistema de criptografia do mundo");
            Console.WriteLine("Digite:");
            Console.WriteLine("1 para Criptografar");
            Console.WriteLine("2 para Descriptografar ");
            Console.WriteLine("0 para Fechar o programa");
            // "escolha" para deslocar à algum lugar do programa
            escolha = Console.ReadLine();
            switch (escolha)
            {
                case "1":
                    Console.Clear();
                    goto cript;
                case "2":
                    Console.Clear();
                    goto descrip;
                case "0":
                    Console.Clear();
                    goto saida;
                default:
                    Console.Clear();
                    Console.WriteLine("Opção inválida");
                    Console.ReadKey();
                    Console.Clear();
                    goto comeco;
            }
            // Início da criptografia
        cript:
            Console.Write("Digite a mensagem para ser criptografada: ");
            // Mensagem original escrita pelo usuário para ser criptografada
            mensagem = Console.ReadLine();
            if (mensagem.Length > 128)
            {
                Console.Write("Sua mensagem possui mais do que 128 caracteres!");
                Console.ReadKey();
                Console.Clear();
                goto cript;
            }

        digitetexto:

            if (volta == true)
            {
                Console.WriteLine("Digite a mensagem para ser criptograda: {0}", mensagem);
            }
            Console.Write("Digite a senha: ");
            chaved = Console.ReadLine();
            chaveint = int.TryParse(chaved, out chave1);
            if (chaveint)
            {
            }
            else
            {
                Console.WriteLine("Comando inválido, digite apenas números");
                Console.ReadKey();
                Console.Clear();
                volta = true;
                goto digitetexto;

            }
            // Deslocamento de caracteres 
            for (int j = 0; j < mensagem.Length; j++)
            {
                for (int i = 0; i < letras.Length; i++)
                {
                    if (Convert.ToChar(letras.Substring(i, 1)) == mensagem[j])
                    {
                        troca = letras.IndexOf(mensagem[j]) + chave * chave1;
                        while (troca >= letras.Length)
                        {
                            troca -= letras.Length;
                        }
                        MsgCrip.Append(letras[troca]);
                        break;
                    }
                }
            }
            for (int i = 2; i < MsgCrip.Length; i++)
            {
                if (i % 2 == 0)
                {
                    mp2++;
                }
            }
            descarte = new char[mp2 + MsgCrip.Length + 1];
            // Chamada da função Aleat09
            for (int i = 0; i < descarte.Length; i++)
            {
                
                if (i == 0)
                {
                    descarte[0] = Convert.ToChar(Aleat09(i));
                    descarte[1] = MsgCrip[0];
                    mp3++;
                }
                else if (i % 3 == 0)
                {
                    descarte[i] = Convert.ToChar(Aleat09(i));
                    mp3++;
                }
                else if (i != 1)
                {
                    descarte[i] = MsgCrip[i - mp3];
                }
            }
            // Inversão da mensagem
            text_inv = descarte;
            Array.Reverse(text_inv);
            Console.WriteLine(text_inv);
            Console.ReadKey();
            Console.Clear();
            goto comeco;

            // Inicio da descriptografia
        descrip:
            StringBuilder MsgDescrip = new StringBuilder();
           // Digitação da mensagem já criptografada
            Console.Write("Digite a mensagem criptografada: ");
            mensagem = Console.ReadLine();
        digitetextod:
            if (voltac == true)
            {
                Console.WriteLine("Digite a mensagem criptografada: {0}", mensagem);
            }
            Console.Write("Digite a senha: ");
            chaved = Console.ReadLine();
            chaveint = int.TryParse(chaved, out chave1);
            if (chaveint)
            {
            }
            else
            {
                Console.WriteLine("Comando inválido, digite apenas números");
                Console.ReadKey();
                Console.Clear();
                voltac = true;
                goto digitetextod;
            }
            // Deslocamento dos caracteres
            for (int j = 0; j < mensagem.Length; j++)
            {
                for (int i = 0; i < letras.Length; i++)
                {
                    if (Convert.ToChar(letras.Substring(i, 1)) == mensagem[j])
                    {
                        troca = letras.IndexOf(mensagem[j]) - chave * chave1;
                        while (troca < 0)
                        {
                            troca += letras.Length;
                        }
                        MsgDescrip.Append(letras[troca]);
                        break;
                    }
                }
            }
            // Retirar os números gerados pela função Aleat09
            descarte = new char[MsgDescrip.Length];
            for (int i = 0; i < MsgDescrip.Length; i++)
            {
                if (MsgDescrip[i] == '0' || MsgDescrip[i] == '1' || MsgDescrip[i] == '2' || MsgDescrip[i] == '3' || MsgDescrip[i] == '4' || MsgDescrip[i] == '5' || MsgDescrip[i] == '6' || MsgDescrip[i] == '7' || MsgDescrip[i] == '8' || MsgDescrip[i] == '9')
                {
                    mp3++;
                }
                else
                {
                    descarte[i - mp3] = MsgDescrip[i];
                }

            }
            // Inverte a mensagem
            text_inv = descarte;
            Array.Reverse(text_inv);
            Console.WriteLine(text_inv);
            Console.ReadKey();
            Console.Clear();
            goto comeco;
        saida:
            Console.ReadKey();

        }

    }
}

