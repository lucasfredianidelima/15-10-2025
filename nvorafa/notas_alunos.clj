(ns notas-alunos)


(def mensagem-excelente "Turma excelente!")
(def mensagem-bom "Bom desempenho!")
(def mensagem-melhorar "É necessário melhorar!")


(defn obter-conceito [nota]
  (cond
    (>= nota 90) "A"
    (>= nota 80) "B"
    (>= nota 70) "C"
    (>= nota 60) "D"
    :else "F"))


(defn avaliar-desempenho [media]
  (if (>= media 80)
    mensagem-excelente
    (if (>= media 60)
      mensagem-bom
      mensagem-melhorar)))


(defn main []
  (println "Quantos alunos na turma?")
  (let [num-alunos (Integer/parseInt (read-line))]
    (loop [contador 1
           soma-notas 0
           aprovados 0]
      (if (<= contador num-alunos)
        (do
          (println (str "\nNome do aluno " contador ":"))
          (let [nome (read-line)
                _ (println "Nota:")
                nota (Integer/parseInt (read-line))
                conceito (obter-conceito nota)]
            (println (str nome " - Conceito: " conceito))
            (recur (inc contador)
                  (+ soma-notas nota)
                  (if (>= nota 60)
                    (inc aprovados)
                    aprovados))))
        (let [media (double (/ soma-notas num-alunos))]
          (println (str "\nMédia da turma: " media))
          (println (str "Aprovados: " aprovados))
          (println (str "Desempenho geral: " (avaliar-desempenho media))))))))


(main)